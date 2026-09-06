package com.jos.firewall

import android.app.Application
import com.jos.firewall.data.AppDatabase
import com.jos.firewall.firewall.RuleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class JosFirewallApp : Application() {

    val applicationScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val ruleRepository by lazy { RuleRepository(database, applicationScope) }

    override fun onCreate() {
        super.onCreate()
    }
}
