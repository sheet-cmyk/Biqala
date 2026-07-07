package com.grocery.app.data.remote.messaging

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class GroceryMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        // Handle push notification
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Send token to server when it refreshes
    }
}
