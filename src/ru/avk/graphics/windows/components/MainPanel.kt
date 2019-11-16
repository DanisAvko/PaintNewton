package ru.avk.graphics.windows.components

import ru.avk.graphics.painters.DecartPainter
import ru.avk.graphics.painters.NewtonPainter
import java.awt.Graphics
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JPanel

class MainPanel(var painter:NewtonPainter,var DPainter:DecartPainter):JPanel() {
    init{
        addComponentListener(
           object:ComponentAdapter(){
               override fun componentResized(e: ComponentEvent?) {
                 repaint()
               }
           }
        )

    }

    override fun paint(g: Graphics?) {
        DPainter.plane.realWidth = width
        DPainter.plane.realHeight = height
        super.paint(g)
        if (g!=null) {
            DPainter.paint(g)
            painter.paint(g)
        }
    }
}