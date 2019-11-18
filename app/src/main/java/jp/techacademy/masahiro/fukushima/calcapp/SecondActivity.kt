package jp.techacademy.masahiro.fukushima.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import android.util.Log

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // getFloatExtraメソッドでデータ受け取り
        val result = intent.getFloatExtra("RESULT", 0.0f)
        // 正規表現により小数末尾を取り除く
        val regex = Regex(".0+\$")
        textView.text = regex.replace(result.toString(), "")
    }
}
