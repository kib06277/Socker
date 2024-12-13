package com.funshow.socketdemo

import android.util.Log
import dev.icerock.moko.socket.Socket
import dev.icerock.moko.socket.SocketEvent
import dev.icerock.moko.socket.SocketOptions

class Testing {
    //endpoint = "https://sock-01.168money.com.tw:10003"
    //endpoint = "https://socket.168money.com.tw:2053"
    val socket = Socket(
        endpoint = "https://sock-01.168money.com.tw:10003",
        config = SocketOptions(
            queryParams = mapOf("param1" to "1", "param2" to "2"),
            transport = SocketOptions.Transport.WEBSOCKET
        )
    ) {
        on(SocketEvent.Connect) {
            Log.i("FunshowError" ,"connect")
        }

        on(SocketEvent.Connecting) {
            Log.i("FunshowError" ,"connecting")
        }

        on(SocketEvent.Disconnect) {
            Log.i("FunshowError" ,"disconnect")
        }

        on(SocketEvent.Error) {
            Log.i("FunshowError" ,"error $it")
        }

        on(SocketEvent.Reconnect) {
            Log.i("FunshowError" ,"reconnect")
        }

        on(SocketEvent.ReconnectAttempt) {
            Log.i("FunshowError" ,"reconnect attempt $it")
        }

        on(SocketEvent.Ping) {
            Log.i("FunshowError" ,"ping")
        }

        on(SocketEvent.Pong) {
            Log.i("FunshowError" ,"pong")
        }

        listOf(
            "pushCallAPI",
            "KeywordLottery",
            "ProductCardModule",
            "marquee",
            "countdown",
            "ultimate_password",
            "vote",
            "down_marquee",
            "keyword_lottery",
            "lottery_pressure",
            "continue_buy",
            "live_sales",
            "live_sales_bidding",
            "live_product_fight_more",
            "facebook_live_message",
            "app_screenshot",
            "new_sale_page_product_screenshot",
            "live_stream",
            "facebook_page_live_feed",
            "live_sale_winner_prompt_message",
            "live_sales_single_bind_multi_spec",
            "app_screenshot_single_bid_multi_spec",
            "live_sales_multi_bind",
            "add user",
            "app_screenshot_multi_bid"
        ).forEach { eventName ->
            on(eventName) { data ->
                Log.i("FunshowError" ,"$eventName $data")
            }
        }
    }

    fun login() {
        socket.emit("add user", "mokoSocketIo")
    }
}