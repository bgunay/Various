package pl.jvsystem.restbuilder

import groovyx.net.http.RESTClient

//def twitter = new RESTClient( 'https://api.twitter.com/1.1/statuses/' )

//
//def resp = twitter.get( path : 'home_timeline.json' )
//assert resp.status == 200
//assert resp.contentType == ContentType.JSON.toString()
//assert ( resp.data instanceof List )
//assert resp.data.status.size() > 0
//println '--------------'
//println resp.data

def str = new RESTClient( 'http://localhost:8080/stranalysis/' )
def resp = str.get( path : 'app/version.json' )
println '--------------'
println "Version $resp.data.version"