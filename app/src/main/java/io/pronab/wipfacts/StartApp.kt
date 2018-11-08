package io.pronab.wipfacts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.pronab.wipfacts.ui.startapp.ListFactsFragment

class StartApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.start_app_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFactsFragment.newInstance())
                .commitNow()
        }
    }

}
