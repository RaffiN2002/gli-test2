package com.example.glitest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class student_list : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Student>
    lateinit var imageId : Array<Int>
    lateinit var name : Array<String>
    lateinit var address : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        imageId = arrayOf(R.drawable.ramiro_pianarosa_xd4ao7alxb0_unsplash,
            R.drawable.usman_yousaf_7m88qnnhxae_unsplash,
            R.drawable.yusron_el_jihan_cnqy447qidk_unsplash,
            R.drawable.smiling_asian_woman_with_notebooks_student_with_happy_face_promo_college_education_blue_backgroun,
            R.drawable.soheyl_dehghani_dk_drmjvna0_unsplash,
            R.drawable.ayo_ogunseinde_6w4f62sn_yi_unsplash,
            R.drawable.dominick_cheers_zgm1zgijutc_unsplash,
            R.drawable.erik_lucatero_d2msdujjl2g_unsplash,
            R.drawable.oliver_ragfelt_s5zc3nywvri_unsplash,
            R.drawable.striped_man_stood_with_his_arms_folded_shocked)
        name = arrayOf("Alan Drake", "Ethan Walker", "Alexander Reed","Rachel Thompson","Emily Johnson",
            "Dylan Baker","Christopher Davis","Ryan Walker","Kevin Brooks","David Thompson")
        address = arrayOf("23 Oak Street, Columbus, Ohio", "56 Maple Avenue, Chicago, Illinois",
            "09 Elm Road, Houston, Texas", "101 Pine Lane, Denver, Colorado",
            "34 Cedar Drive, Portland, Oregon","07 Birch Street, Miami, Florida",
            "90 Willow Court, Atlanta, Georgia","345 Spruce Avenue, Boston, Massachusetts",
            "08 Magnolia Lane, Seattle, Washington","12 Sycamore Road, Nashville, Tennessee")

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Student>()
        getUserData()
    }

    private fun getUserData(){
        for (i in imageId.indices){
            val contact = Student(imageId[i],name[i],address[i])
            newArrayList.add(contact)
        }
        newRecyclerView.adapter = Adapter(newArrayList)
    }
}