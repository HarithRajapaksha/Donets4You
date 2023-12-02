package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Adapter.DonationClassAdapter
import com.example.Model.AddCampModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DonationCampsFetchdata : AppCompatActivity() {

    private lateinit var employeeItem: RecyclerView
    private lateinit var empList:ArrayList<AddCampModel>
    private lateinit var dbRef: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation_camps_fetchdata)

        firebaseAuth = FirebaseAuth.getInstance()

        employeeItem=findViewById(R.id.rid)
        employeeItem.layoutManager= LinearLayoutManager(this,)
        employeeItem.setHasFixedSize(true)
        empList= arrayListOf<AddCampModel>()

        getEmployeeData()

    }

    private fun getEmployeeData(){
        employeeItem.visibility= View.GONE
        dbRef= FirebaseDatabase.getInstance().getReference("BloodCamp_Data")

        val auth1 = firebaseAuth.currentUser
        val userId = auth1?.uid

        val fetch = dbRef //.orderByChild(userId.toString())

        fetch.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if(snapshot.exists()){
                    for (inquiry in snapshot.children){
                        val inqData=inquiry.getValue(AddCampModel::class.java)
                        empList.add(inqData!!)
                    }
                    val mAdapter=DonationClassAdapter(empList)


                    employeeItem.adapter=mAdapter
                    employeeItem.visibility= View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}