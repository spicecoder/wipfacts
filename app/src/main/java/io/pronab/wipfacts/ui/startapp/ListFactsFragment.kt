package io.pronab.wipfacts.ui.startapp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.pronab.wipfacts.R
import io.pronab.wipfacts.domain.ListFactsViewModel

class ListFactsFragment : Fragment() {

    companion object {
        fun newInstance() = ListFactsFragment()
    }

    private lateinit var viewModel: ListFactsViewModel
    internal var factsViewAction: FactsViewActionsSingleton? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.list_facts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        factsViewAction = FactsViewActionsSingleton.instance
        factsViewAction?.setFragment(this)
        viewModel = ViewModelProviders.of(this).get(ListFactsViewModel::class.java)
        // TODO: Use the ViewModel
        factsViewAction?.setTitle("hello title from vm")
    }

}
