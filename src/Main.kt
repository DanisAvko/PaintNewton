import ru.avk.graphics.windows.Window
import ru.avk.polynoms.Lagrange
import ru.avk.polynoms.Newton
import ru.avk.polynoms.Polynom
import java.util.*



fun main() {
   println(Polynom(arrayOf(0.0,1.0,3.0,4.0)))
   print(Polynom(arrayOf(0.0,1.0,3.0,4.0)).deravative())
   Window()
}