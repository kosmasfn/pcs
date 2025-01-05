package com.kosmasfn.pcs.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kosmasfn.pcs.databinding.ActivityDetailBinding
import com.kosmasfn.pcs.model.TestUIModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private var data: TestUIModel = TestUIModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initExtra()
        initAdapter()
    }

    private fun initExtra() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(TEST_DETAIL, TestUIModel::class.java)?.let {
                    data = it
                }
            } else {
                intent.getSerializableExtra(TEST_DETAIL)?.let {
                    data = it as TestUIModel
                }
            }
        } catch (_: Exception) {
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initAdapter() {
        with(binding) {
            Glide.with(ivData.context)
                .load(data.avatar)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(ivData)

            var name = data.name
            var lastname = ""

            if (data.name.contains(" ")) {
                val nameTemp = data.name.split(" ")
                name = nameTemp[0]
                lastname = nameTemp[1]
            }

            tvName.text = name
            tvLastName.text = lastname
            tvAddress.text =
                data.addressNo + ", " + data.street + ", " + data.county + ", " + data.city + ", " + data.country + ", " + data.zipCode
        }
    }

    companion object {
        const val TEST_DETAIL = "TEST_DETAIL"
        fun launchIntent(context: Context, data: TestUIModel) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(TEST_DETAIL, data)
            context.startActivity(intent)
        }
    }
}