package ru.avk.graphics.painters

import ru.avk.polynoms.Newton
import ru.avk.polynoms.Polynom
import ru.avk.graphics.Converter.CartesianScreenPlane
import ru.avk.graphics.Converter.Converter
import java.awt.Color
import java.awt.Graphics


class NewtonPainter(var plane:CartesianScreenPlane,var p:Newton) {
    var boolPaintDeravative:Boolean=false;
    init {


    }
    fun PaintPolynom(p:Polynom,g:Graphics){
        for (i in 0..plane.realWidth) {
            val y1 = Converter.yCrt2Scr(p.getValue(Converter.xScr2Crt(i, plane)),plane)
            val y2 = Converter.yCrt2Scr(p.getValue(Converter.xScr2Crt(i+1, plane)),plane)
            g.drawLine(i,y1,i+1,y2)
        }
    }
    fun paint(g:Graphics) {
        g.color = Color.GREEN
        if (p.valx.size >= 1) {
            PaintPolynom(p, g)
            g.color = Color.DARK_GRAY
            p.valx.indices.forEach {
                g.fillOval(Converter.xCrt2Scr(p.valx[it], plane) - 3, Converter.yCrt2Scr(p.valy[it], plane) - 3, 6, 6)
            }
            if (boolPaintDeravative) {
                g.color = Color.ORANGE
                PaintPolynom(p.deravative(), g)
            }
        }
    }
}