/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.javatips.factory

import java.awt.Image
import javax.swing.Icon
import com.wordpress.tipsforjava.swing.RotatedIcon

import groovy.swing.factory.ImageIconFactory
import static org.codehaus.griffon.factory.FactoryUtils.toDouble

/**
 * @author Andres Almiray
 */
class RotatedIconFactory extends ImageIconFactory {
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
	    def angle = attributes.remove('angle')
	    RotatedIcon.Rotate rotate = parseRotate(attributes.remove('rotate'))
	
	    Icon icon = null
        if(value instanceof Icon) {
	        icon = value
        } else if(attributes.containsKey('icon')) {
	        icon = attributes.remove('icon')
        } else {
            if(value instanceof Image) {
	            attributes.image = value
	            value = null
            }
            icon = super.newInstance(builder, name, value, attributes)
        }

        angle != null ? new RotatedIcon(icon, toDouble(angle, 0d)) : new RotatedIcon(icon, rotate)
    }

    private static RotatedIcon.Rotate parseRotate(r) {
	    if(r instanceof RotatedIcon.Rotate) return r
	    if(!r) return RotatedIcon.Rotate.UP
	    switch(r.toString().toUpperCase()) {
		    case 'UP': return RotatedIcon.Rotate.UP;
		    case 'DOWN': return RotatedIcon.Rotate.DOWN;
		    case 'UPSIDE_DOWN': return RotatedIcon.Rotate.UPSIDE_DOWN;
		    case 'ABOUT_CENTER': return RotatedIcon.Rotate.ABOUT_CENTER;
	    }
	    return RotatedIcon.Rotate.UP;
    }
}