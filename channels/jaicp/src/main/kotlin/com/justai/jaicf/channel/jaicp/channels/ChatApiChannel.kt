package com.justai.jaicf.channel.jaicp.channels

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.jaicp.dto.ChatApiBotRequest
import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.reactions.ChatApiReactions

/**
 * JAICP ChatApi channel
 *
 * This channel can be used for processing GET/POST request with queries on JAICP server url
 * СhatApiChannel can be configured only in JAICP Web Interface.
 * Client information can be retrieved from [ChatApiBotRequest].
 *
 * @see ChatApiReactions
 * @see ChatApiBotRequest
 * @see JaicpNativeChannel
 *
 * @param botApi the [BotApi] implementation used to process the requests to this channel
 * */
class ChatApiChannel(override val botApi: BotApi) : JaicpNativeChannel(botApi) {

    override fun createRequest(request: JaicpBotRequest) = ChatApiBotRequest(request)
    override fun createReactions() = ChatApiReactions()

    companion object : JaicpNativeChannelFactory {
        override val channelType = "chatapi"
        override fun create(botApi: BotApi) = ChatApiChannel(botApi)
    }
}