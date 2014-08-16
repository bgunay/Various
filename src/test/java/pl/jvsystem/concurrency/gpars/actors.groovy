package pl.jvsystem.concurrency.gpars

import static groovyx.gpars.actor.Actors.actor

def decryptor = actor {
	loop {
		react { message ->
			if (message instanceof String) reply message.reverse()
			else stop()
		}
	}
}

def console = actor {
	decryptor << 'lellarap si yvoorG' // << means send
	react {
		println 'Decrypted message: ' + it
		decryptor << false
	}
}

[decryptor, console]*.join()