
Swing components from tips4java
-------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/javatips](http://artifacts.griffon-framework.org/plugin/javatips)


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

