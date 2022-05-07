package com.mellda.commands

import com.lambda.client.command.ClientCommand
import com.lambda.client.util.text.MessageSendHelper
import net.minecraft.entity.passive.EntityDonkey
import net.minecraft.item.ItemShears
import net.minecraft.network.play.client.*
import net.minecraft.util.EnumHand


object CowdupeCommand : ClientCommand(
    name = "cowdupe",
    description = "Example command"
) {
    init {
          int("ID") { id ->
              int("loop") {loop ->
                  executeSafe {
                      if (player.inventory.getCurrentItem().item is ItemShears) {
                          val entity = EntityDonkey(world)
                          entity.entityId = id.value
                          for (i in 1..loop.value)
                              connection.sendPacket(CPacketUseEntity(entity, EnumHand.MAIN_HAND))
                          MessageSendHelper.sendChatMessage("Trying to cowdupe")
                      }
                      else{
                          MessageSendHelper.sendChatMessage("Please hold the shears")
                      }
                  }
              }
          }
    }
}