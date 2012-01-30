package custom.attribute
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute
import org.apache.lucene.analysis.tokenattributes.TermAttribute
import org.apache.lucene.util.AttributeImpl
import org.apache.lucene.util.AttributeReflector

class CharTermAttributeImpl(
    private val origin: org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl
) extends AttributeImpl with CharTermAttribute with Cloneable with Serializable {
  def this() = {
    this(new org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl())
  }
  def copyBuffer(buf: Array[Char], offset:Int, length:Int) = origin.copyBuffer(buf, offset, length)
  def buffer() = origin.buffer()
  def resizeBuffer(newSize:Int) = {
    print("before size: %s, newSize: %s".format(origin.buffer.length, newSize))
    val result = origin.resizeBuffer(newSize)
    println(", after size: %s".format(origin.buffer.length))
    result
  }
  def setLength(len:Int) = origin.setLength(len)
  def setEmpty() = origin.setEmpty()
  def length() = origin.length()
  def charAt(index:Int) = origin.charAt(index)
  def subSequence(start:Int, end:Int) = origin.subSequence(start, end)
  def append(csq:CharSequence) = origin.append(csq)
  def append(csq:CharSequence, start:Int, end:Int) = origin.append(csq, start, end)
  def append(c:Char) = origin.append(c)
  def append(s:String) = origin.append(s)
  def append(sb:java.lang.StringBuilder) = origin.append(sb)
  def append(ta:CharTermAttribute) = origin.append(ta)
  override def hashCode() = origin.hashCode()
  def clear() = origin.clear()
  override def clone(): Object = 
    new CharTermAttributeImpl(
        origin.clone().asInstanceOf[org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl])
  override def equals(other:Any) = {
    if (other == this) {
      true
    } else {
      other match {
        case o:CharTermAttributeImpl => origin.equals(o.origin)
        case _ => false
      }
    }
  }
  override def toString() = origin.toString()
  override def reflectWith(reflector: AttributeReflector) = origin.reflectWith(reflector)
  def copyTo(target: AttributeImpl):Unit = {
    target match {
      case t:CharTermAttributeImpl => origin.copyTo(t.origin)
      case _ => 
    }
  }
}