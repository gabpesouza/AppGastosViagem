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

    private fun isValid(): Boolean{
        (return binding.editDistance.text.toString() != ""
         && binding.editPrice.text.toString() != ""
         && binding.editAutonomy.text.toString() != ""
         && binding.editAutonomy.text.toString().toFloat() != 0f);
    }

    private fun calculate(){

        if(isValid()){

            val distance = binding.editDistance.text.toString().toFloat();
            val price = binding.editPrice.text.toString().toFloat();
            val autonomy = binding.editAutonomy.text.toString().toFloat();

            var totalValue = (distance * price) / autonomy;
            var totalValueString = "R$:${"%.2f".format(totalValue)}"


            binding.textTotalvalue.text = totalValueString;

        }else{
            Toast.makeText(this,"Preencha os campos corretamente",Toast.LENGTH_SHORT).show();
        }


        //Toast.makeText(this, totalValueString,Toast.LENGTH_SHORT).show();
    }



}