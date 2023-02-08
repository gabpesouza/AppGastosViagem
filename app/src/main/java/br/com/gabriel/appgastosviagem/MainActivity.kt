package br.com.gabriel.appgastosviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.gabriel.appgastosviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
       if(view.id == R.id.button_calculate){
           calculate();
       }
    }

    private fun calculate(){

        val distance = binding.editDistance.text.toString().toFloat();
        val price = binding.editPrice.text.toString().toFloat();
        val autonomy = binding.editAutonomy.text.toString().toFloat();

        var totalValue = (distance * price) / autonomy;
        var totalValueString = "R$:${"%.2f".format(totalValue)}"

        binding.textTotalvalue.text = totalValueString;


        //Toast.makeText(this, totalValueString,Toast.LENGTH_SHORT).show();
    }



}