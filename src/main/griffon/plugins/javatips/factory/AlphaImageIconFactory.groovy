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
import com.wordpress.tipsforjava.swing.AlphaImageIcon

import groovy.swing.factory.ImageIconFactory
import static org.codehaus.griffon.factory.FactoryUtils.toFloat

/**
 * @author Andres Almiray
 */
class AlphaImageIconFactory extends ImageIconFactory {
    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
	    float alpha = toFloat(attributes.remove('alpha'), 1.0f)
	
        if(value instanceof Icon) {
	        return new AlphaImageIcon(value, alpha)
        } else if(attributes.containsKey('icon')) {
	        return new AlphaImageIcon(attributes.remove('icon'), alpha)
        }

        if(value instanceof Image) {
	        attributes.image = value
	        value = null
        }

        Icon icon = super.newInstance(builder, name, value, attributes)
        new AlphaImageIcon(icon, alpha)
    }
}