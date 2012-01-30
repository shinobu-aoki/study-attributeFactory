package custom

import java.lang.ref.WeakReference
import java.util.{LinkedHashMap,WeakHashMap}
import org.apache.lucene.util.{Attribute,AttributeImpl,AttributeSource}
import org.apache.lucene.util.AttributeSource.AttributeFactory

class CustomAttributeFactory private (val basePackage:String) extends AttributeFactory {
  // 実際の環境で使うにはDefaultAttributeFactoryのように、class情報をcacheする必要がある（パフォーマンス上の理由から）
  def createAttributeInstance(attClass:Class[_ <: Attribute]): AttributeImpl = {
    try {
      Class.forName("%s.%s%s".format(basePackage, attClass.getSimpleName, "Impl")).asSubclass(classOf[AttributeImpl]).newInstance()
    } catch {
      // 無ければDefaultの方に委譲（インターフェース+"Impl"で解決させる）
      case e:ClassNotFoundException => AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY.createAttributeInstance(attClass)
    }
  }
}

object CustomAttributeFactory {
  def apply(basePackage:String) = {
    new CustomAttributeFactory(if (basePackage.endsWith(".")) basePackage.init else basePackage)
  }
}
