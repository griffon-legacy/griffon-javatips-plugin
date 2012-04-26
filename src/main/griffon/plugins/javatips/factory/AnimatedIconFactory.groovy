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

import javax.swing.JComponent
import javax.swing.Icon
import com.wordpress.tipsforjava.swing.AnimatedIcon


/**
 * @author Andres Almiray
 */
class AnimatedIconFactory extends AbstractFactory {
    protected static final Icon[] EMPTY_ICON_ARRAY = new Icon[0]

    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
	    FactoryBuilderSupport.checkValueIsType(value, name, AnimatedIcon)
	    return new AnimatedIcon(attributes.remove('component'), EMPTY_ICON_ARRAY)
    }

    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
        if(child instanceof Icon) {
            parent.addIcon(child)
        }
    }

    boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
        def start = attributes.remove('start')
        builder.context['start'] = start != null ? start : true
        return true
    }

    void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        try {
            node.component.icon = node
        } catch(MissingMethodException mme) {
            // ignore
        }
        if(Boolean.valueOf(builder.context.start)) node.start()
    }
}