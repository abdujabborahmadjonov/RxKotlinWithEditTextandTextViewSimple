package dev.abdujabbor.rxkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import dev.abdujabbor.rxkotlin.databinding.ActivityMainBinding
import io.reactivex.Observable

class MainActivity : AppCompatActivity() {
    val binding by  lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myobservable = createobservablestring()
        myobservable.subscribe{
            binding.text.text = it
        }

    }
    private fun createobservablestring():Observable<String>{
        return Observable.create{emmiter-> // rx java ichida bor xabarni yuborib turadi
            // edit text ozgarganda

            binding.edittext.addTextChangedListener {
                emmiter.onNext(it.toString())
                //editTextni jonatadi
            }

        }
    }
}
