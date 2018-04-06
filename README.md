# Android Scanners (Datalogic DL-Axist)
Implements an intent listener for barcode laser builtin scanners.

Datalogic created the android DL-Axist scanners and offers an SDK in order to receive information from the builtin scanner. However we are using different brands of devices and the SDK won't work for those.

Another problem with the SDK is that we need a device to test our apps since it does not run on the AVD.

Both scanners we use send the information as a keyboard wedge and as an implicit intent, we decided not tu use the keyboard events since we do not want them to be able to type any other information that does not come from the scanner to secure that the label is readable.

I decided to do it this way since both brand of scanners send implicit intents and can be received by just adding it to the mainfest. Compatibility between the two brands is better this way.

After all the explanation we can break this in three parts:

# Mainfest
...
# Broadcast Receiver
...
# Observable Object
...


...
