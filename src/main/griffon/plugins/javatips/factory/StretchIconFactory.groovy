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

import com.wordpress.tipsforjava.swing.*

/**
 * @author Andres Almiray
 */
class StretchIconFactory extends IconFactory {
    StretchIconFactory(Class iconClass) {
        super(iconClass)
    }

    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
        value = findIconValue(builder, name, value, attributes)
        boolean proportionate = attributes.containsKey('proportionate') ? attributes.remove('proportionate') as boolean : true
        // exploit multi-dispatch in constructor calls
        if (attributes.containsKey("description")) {
            return iconClass.newInstance(value, attributes.remove("description"), proportionate)
        } else {
            return iconClass.newInstance(value, proportionate)
        }
    }
}
