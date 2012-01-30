package custom.attribute

import org.apache.lucene.util.{Attribute, AttributeImpl}

// テスト用のAttributeのtrait（インターフェース）と実装
trait EmptyAttribute extends Attribute

class EmptyAttributeImpl extends AttributeImpl {
  def copyTo(target:AttributeImpl) = {
    target
  }
  def clear() = {}
}
