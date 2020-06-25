package com.example.internshiptestfathan.menu.profile.viewmodels

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internshiptestfathan.menu.profile.models.ProfileModel
import com.example.internshiptestfathan.network.repositories.ProfileRepository

class ProfileViewModel : ViewModel() {

    private var allData = MutableLiveData<ProfileModel>()

    private val profileRepository = ProfileRepository(viewModelScope)
    var isLoading: ObservableBoolean = ObservableBoolean()
    var userName: ObservableField<String?> = ObservableField()
    var fullName: ObservableField<String?> = ObservableField()
    var email: ObservableField<String?> = ObservableField()
    var phone: ObservableField<String?> = ObservableField()
    var avatar: ObservableField<String?> = ObservableField()


    internal fun setProfileData(){

        profileRepository.getProfile({

            isLoading.set(true)

            it?.let {
                userName.set(it.username)
                fullName.set(it.fullname)
                email.set(it.email)
                phone.set(it.phone)
                avatar.set(it.avatar)
            }
            Log.i("DATA", it.toString())
            allData.postValue(it)
            isLoading.set(false)

        },{
            //Log.e("Gallery", it.message)
        }
        )
    }

    internal fun getProfileData() : LiveData<ProfileModel> {
        return allData
    }
}