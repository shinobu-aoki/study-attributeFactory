package custom
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.scalatest.FlatSpec
import org.apache.lucene.analysis.tokenattributes.{CharTermAttribute, OffsetAttribute, OffsetAttributeImpl}
import org.apache.lucene.util.{Attribute, AttributeImpl}

class CustomAttributeFactoryTest extends FlatSpec with ShouldMatchers {
  "A CustomAttributeFactory" should "be available" in {
    CustomAttributeFactory.isInstanceOf[Singleton] should be (true)
    val instance = CustomAttributeFactory("");
    instance should not be null
  }
  it should "create an attributeInstance of the specified package" in {
    val instance = CustomAttributeFactory("custom.attribute")
    // custom.attributeのインターフェースと実装
    val emptyAtt = instance.createAttributeInstance(classOf[attribute.EmptyAttribute])
    emptyAtt should not be null
    emptyAtt.isInstanceOf[attribute.EmptyAttributeImpl] should be (true)
    // 実装のみ存在するパターン（上書きしたいケース）
    val charTermAtt = instance.createAttributeInstance(classOf[CharTermAttribute])
    charTermAtt should not be null
    charTermAtt.isInstanceOf[attribute.CharTermAttributeImpl] should be (true)
    // custom.attributeに実装が存在しないケース
    val offsetAtt = instance.createAttributeInstance(classOf[OffsetAttribute])
    offsetAtt should not be null
    offsetAtt.isInstanceOf[OffsetAttributeImpl] should be (true)
  }
}