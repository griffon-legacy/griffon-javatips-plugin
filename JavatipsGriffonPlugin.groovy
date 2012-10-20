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

/**
 * @author Andres Almiray
 */
class JavatipsGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, qt
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-javatips-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Swing components from tips4java'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
This plugin delivers tons of components created by Rob Camick & Darryl Burk, posted at the [Java Tips Weblog][1].

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*                  | *Property* | *Type*             |
| ----------------------- | ---------- | ------------------ |
| alphaContainer          | component  | JComponent         |
| backgroundPanel         |            |                    |
| caretPositionListener   |            |                    |
| formScroller            | target     | JScrollPane        |
|                         | type       | FormScroller.Type  |
| mouseWheelController    | target     | JScrollPane        |
| marqueePanel            | start      | boolean            |
| overlapLayout           |            |                    |
| relativeLayout          |            |                    |
| rxcardLayout            |            |                    |
| scrollablePanel         |            |                    |
| selectButtonGroup       |            |                    |
| sizeDocumentFilter      |            |                    |
| toolTipListener         |            |                    |
| upperCaseDocumentFilter |            |                    |
| wrapLayout              |            |                    |
| alphaIcon               | alpha      | float              |
|                         | icon       | Icon               |
| alphaImageIcon          | alpha      | float              |
|                         | icon       | Icon               |
| animatedIcon            | component  | JComponent         |
|                         | start      | boolean            |
| circularAnimatedIcon    | component  | JComponent         |
|                         | start      | boolean            |
| dualIcon                | icon1      | Icon               |
|                         | icon2      | Icon               |
| rotatedIcon             | angle      | double             |
|                         | rotate     | RotatedIcon.Rotate |
|                         | icon       | Icon               |

Nest icon nodes in `animatedIcon` and `circularAnimatedIcon`.

The following properties can be used with `alphaImageIcon`, `rotatedIcon`, `tileIcon`, `thumbnailIcon`, `stretchIcon`, `shrinkIcon`

| *Property*  | *Type* | *Notes*                       |
| ----------- | ------ | ----------------------------- |
| description | String |                               |
| image       | Image  |                               |
| url         | URL    |                               |
| file        | File   |                               |
| resource    | String |                               |
| class       | Class  | use it along with `resource:` |

Refer to the Javadocs found in the plugin's distribution to learn more about the properties that can be set on these nodes. There are
much more helper classes included in this plugin. Refer to [http://tips4java.wordpress.com][1] to learn more about their usage.

[1]: http://tips4java.wordpress.com/
'''
}
