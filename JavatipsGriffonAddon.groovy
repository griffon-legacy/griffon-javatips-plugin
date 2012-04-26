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

import com.wordpress.tipsforjava.swing.*
import com.wordpress.tipsforjava.swing.text.*
import griffon.plugins.javatips.factory.*
import groovy.swing.factory.ComponentFactory
import groovy.swing.factory.LayoutFactory

/**
 * @author Andres Almiray
 */
class JavatipsGriffonAddon {
    def factories = [
        alphaContainer: new AlphaContainerFactory(),
        backgroundPanel: new ComponentFactory(BackgroundPanel),
        caretPositionListener: CaretPositionListener,
        formScroller: new FormScrollerFactory(),
        mouseWheelController: new MouseWheelControllerFactory(),
        marqueePanel: new MarqueePanelFactory(),
        overlapLayout: new LayoutFactory(OverlapLayout),
        relativeLayout: new LayoutFactory(RelativeLayout),
        rxcardLayout: new LayoutFactory(RXCardLayout),
        scrollablePanel: new ComponentFactory(ScrollablePanel),
        selectButtonGroup: new SelectButtonGroupFactory(),
        sizeDocumentFilter: SizeDocumentFilter,
        toolTipListener: ToolTipListener,
        upperCaseDocumentFilter: UpperCaseDocumentFilter,
        wrapLayout: new LayoutFactory(WrapLayout),

        alphaIcon: new AlphaIconFactory(),
        alphaImageIcon: new AlphaImageIconFactory(),
        animatedIcon: new AnimatedIconFactory(),
        circularAnimatedIcon: new CircularAnimatedIconFactory(),
        dualIcon: new DualIconFactory(),
        rotatedIcon: new RotatedIconFactory(),
        thumbnailIcon: new IconFactory(ThumbnailIcon),
        tileIcon: new IconFactory(TileIcon),
        stretchIcon: new StretchIconFactory(StretchIcon),
        shrinkIcon: new StretchIconFactory(ShrinkIcon)
    ]
}
