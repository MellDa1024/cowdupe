package com.mellda

import com.lambda.client.plugin.api.Plugin
import com.mellda.commands.CowdupeCommand

internal object CowdupePlugin : Plugin() {

    override fun onLoad() {
        // Load any modules, commands, or HUD elements here
        commands.add(CowdupeCommand)
    }

    override fun onUnload() {
        // Here you can unregister threads etc...
    }
}