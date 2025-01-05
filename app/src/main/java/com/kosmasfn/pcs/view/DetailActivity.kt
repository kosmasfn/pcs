package com.kosmasfn.pcs.view

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.kosmasfn.core.base.convertToLocalDateString
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

    private fun initAdapter() {
        with(binding) {
            Glide.with(ivData.context)
                .load(data.avatar)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(ivData)

            tvName.text = data.name
            tvStreet.text = data.street
            tvAddress.text = data.addressNo
            tvCounty.text = data.county
            tvCity.text = data.city
            tvCountry.text = data.country
            tvZipcode.text = data.zipCode
            tvCreatedAt.text = data.createdAt.convertToLocalDateString()
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