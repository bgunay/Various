package com.github.pnowy.various.restbuilder

import groovyx.net.http.ContentType
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

//def str = new RESTClient( 'http://localhost:8080/stranalysis/' )
//def resp = str.get( path : 'app/version.json' )
//println '--------------'
//println "Version $resp.data.version"

def sampleHubRest = new RESTClient('http://resdev.gene.com/samplehub-rest/api/', ContentType.JSON)
def wsPath = "v1/sample/639389,639390"

def resp = sampleHubRest.get(path: wsPath)

resp.data.content.each { sampleResp ->
	println sampleResp.id.toLong()
	sampleResp.attributes.each {
		println "\t$it.columnName"
	}
}