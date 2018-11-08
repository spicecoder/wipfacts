package io.pronab.wipfacts.ui.startapp

import android.support.v4.app.Fragment
import java.io.Serializable

/*
viewaction singleton encapsulates all actions of interacting with view data  and its rendring;
its main function is to free up the code within fragment or activity that does not relate to its
life cycle or  fragments  binding. The singleton is destroyed on detach /destroy of fragment.

 */
class FactsViewActionsSingleton
//View contentView;

private constructor() : Serializable {


    private var currentFragment: Fragment? = null

    init {
        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw RuntimeException("Use getInstance() method to get the single instance of this class.")
        }
    }


    fun setFragment(UIController: ListFactsFragment) {
        currentFragment = UIController
    }



    internal fun setTitle(title:String) {
        currentFragment?.activity?.title = title
    }




    companion object {

        @Volatile
        private var sSoleInstance: FactsViewActionsSingleton? = FactsViewActionsSingleton()


        //Double check locking pattern
        //Check for the first time
        //Check for the second time.
        //if there is no instance available... create new one
        val instance: FactsViewActionsSingleton?
            get() {
                if (sSoleInstance == null) {

                    synchronized(FactsViewActionsSingleton::class.java) {
                        if (sSoleInstance == null) sSoleInstance = FactsViewActionsSingleton()
                    }
                }
                return sSoleInstance

            }

    }

    //Make singleton from serialize and deserialize operation.

    private fun readResolve(): FactsViewActionsSingleton? {
        return instance
    }


}