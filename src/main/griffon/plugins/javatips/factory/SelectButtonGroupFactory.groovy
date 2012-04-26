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

import javax.swing.AbstractButton
import groovy.swing.factory.BeanFactory
import com.wordpress.tipsforjava.swing.SelectButtonGroup

/**
 * @author Andres Almiray
 */
class SelectButtonGroupFactory extends BeanFactory {
    public static final String DELEGATE_PROPERTY_BUTTON_GROUP = "_delegateProperty:buttonGroup"
    public static final String DEFAULT_DELEGATE_PROPERTY_BUTTON_GROUP = "selectButtonGroup"

    public SelectButtonGroupFactory() {
        super(SelectButtonGroup, true)
    }

    public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        builder.context[DELEGATE_PROPERTY_BUTTON_GROUP] = attributes.remove("buttonGroupProperty") ?: DEFAULT_DELEGATE_PROPERTY_BUTTON_GROUP
        return super.newInstance(builder, name, value, attributes);
    }

    public static buttonGroupAttributeDelegate(def builder, def node, def attributes) {
        def buttonGroupAttr = builder?.context?.getAt(DELEGATE_PROPERTY_BUTTON_GROUP) ?: DEFAULT_DELEGATE_PROPERTY_BUTTON_GROUP
        if (attributes.containsKey(buttonGroupAttr)) {
            def o = attributes.get(buttonGroupAttr)
            if ((o instanceof SelectButtonGroup) && (node instanceof AbstractButton)) {
                node.model.group = o
                attributes.remove(buttonGroupAttr)
            }
         }
    }
}