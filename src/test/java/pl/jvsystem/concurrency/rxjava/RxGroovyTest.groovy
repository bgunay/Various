package pl.jvsystem.concurrency.rxjava

import rx.Observable
import spock.lang.Specification


/**
 * RxGroovyTest
 */
class RxGroovyTest extends Specification {

	def "sdf"() {
		setup:

		expect:
		println "a"
//		customObservableBlocking().subscribe {
//			println it
//		}
	}

	def customObservableBlocking() {
		return Observable.create { aSubscriber ->
			50.times { i ->
				if (!aSubscriber.unsubscribed) {
					aSubscriber.onNext("value_${i}")
				}
			}
			if (!aSubscriber.unsubscribed) {
				aSubscriber.onCompleted()
			}
		}
	}

}