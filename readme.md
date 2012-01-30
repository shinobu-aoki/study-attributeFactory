# CustomAttributeFactory

New TokenStream APIのAttributeに対応するインスタンスを作成するAttributeFactoryの実装です。
デフォルトの実装との違いは、指定したパッケージから優先して実装クラス（インターフェース名+"Impl"）を探す点です。指定パッケージに実装クラスが存在しなければ、デフォルトの動作（インターフェースと同じパッケージの実装クラスを探す）を行います。
パフォーマンスなどは考慮していませんので、実際に使う場合はご注意下さい。デフォルト実装と同様にWeakReferenceを使うようにすればOKです。

## 参考URL

AttributeSource.AttributeFactory Javadoc
http://lucene.apache.org/java/3_5_0/api/core/org/apache/lucene/util/AttributeSource.AttributeFactory.html

## 動かし方

```sh
git clone git://github.com/shinobu_aoki/customAttributeFactory.git
cd customAttributeFactory
sbt
```
