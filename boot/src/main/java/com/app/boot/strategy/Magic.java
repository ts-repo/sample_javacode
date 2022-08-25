package com.app.boot.strategy;

/**
 * 種類毎に切り替えたい機能をメソッドにする
 * 1. インターフェースに定義したいメソッドを決める
 * 2. インターフェースの名前を決める。
 * ※このインターフェースを実装するのはなんのクラスか考えることがポイント
 * 魔法ならMagicのような感じ
 * 3.種類をクラス化する⇦ポイント
 * ファイア Fire
 * 紫電 Shiden
 * 地獄の業火 HellFire
 * 4. クラスにインターフェースを実装する
 */
public interface Magic {

    String name(); // 名前
    int costMagicPoint(); //消費魔法力
    int attackPower(); //攻撃力
    int costTechnicalPoint();//消費テクニカルポイント

}
