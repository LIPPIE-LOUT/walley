package com.example.wallet.ui.theme.data



import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.wallet.ui.theme.Navigation.ROUTE_PREVIEW
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Transaction
import com.google.firebase.database.ValueEventListener
import kotlin.contracts.Returns


class TransactionViewModel(var navController: NavHostController, var context: Context) {

    var progress: ProgressDialog

    init {
//        authRepository = AuthViewModel(navController, context)
//        if (!authRepository.isSignedIn()) {
//            navController.navigate(ROUTE_SIGNIN)
//        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait a moment...")
    }


    fun savetransactions(
        date: String,
        day: String,
        amount: String
    ) {
        var id = System.currentTimeMillis().toString()
        var transactionData = com.example.wallet.ui.theme.models.Transaction(date,day,amount,id)
        var transactionRef = FirebaseDatabase.getInstance().getReference()
            .child("Transaction/$id")
        if (date.isEmpty() || day.isEmpty() || amount.isEmpty()){
            Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }else{
            progress.show()
            transactionRef.setValue(transactionData).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Transaction added successfully!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "ERROR: ${it.exception!!.message}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
    }
    fun Preview(
        transaction: MutableState<com.example.wallet.ui.theme.models.Transaction>,
        transactions: SnapshotStateList<com.example.wallet.ui.theme.models.Transaction>
    ): SnapshotStateList<com.example.wallet.ui.theme.models.Transaction> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Transaction")

        progress.show()
        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    progress.dismiss()
                    transactions.clear()
                    for (snap in snapshot.children) {
                        val value = snap.getValue(com.example.wallet.ui.theme.models.Transaction::class.java)
                        transaction.value = value!!
                        transactions.add(value)
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(
                        context,
                        error.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
        return transactions
    }


    fun deleteTransaction(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Transactions/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(
                    context,
                    "The transaction is deleted",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(ROUTE_PREVIEW)
            } else {
                Toast.makeText(
                    context,
                    it.exception!!.message,
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(ROUTE_PREVIEW)
            }
        }
    }

    fun updateTransaction(
        date: String,
        day: String,
        amount: String,
        id: String
    ) {
        val updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Transactions/$id")
        progress.show()
        val updateData =com.example.wallet.ui.theme.models.Transaction(date,day,amount,id )
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(
                    context,
                    "Update successful",
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(ROUTE_PREVIEW)
            } else {
                Toast.makeText(
                    context,
                    it.exception!!.message,
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(ROUTE_PREVIEW)
            }
        }

    }

}