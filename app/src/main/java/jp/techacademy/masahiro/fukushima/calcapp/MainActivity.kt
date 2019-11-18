package jp.techacademy.masahiro.fukushima.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // 一つ目の値を格納するための変数を宣言
        val value1: Float
        // 二つ目の値を格納するための変数を宣言
        val value2: Float
        // 二つの値を四則計算した値を格納するための変数を宣言
        val result: Float

        try {
            value1 = editText1.text.toString().toFloat()
            value2 = editText2.text.toString().toFloat()
        } catch (e: Exception) {
            // 入力されなかった場合、SnackBarを表示
            Snackbar.make(rootLayout, "数値を入力してください", Snackbar.LENGTH_LONG).show()
            return
        }

        when(v.id) {
            R.id.button1 -> {
                result = value1 + value2
            }
            R.id.button2 -> {
                result = value1 - value2
            }
            R.id.button3 -> {
                result = value1 * value2
            }
            R.id.button4 -> {
                result = value1 / value2
            }
            else -> {
                return
            }
        }

        // Intent生成 SecondActivityクラス
        val intent = Intent(this, SecondActivity::class.java)
        // 四則計算した値をputExtraメソッドで設定
        intent.putExtra("RESULT", result)
        startActivity(intent)
    }
}