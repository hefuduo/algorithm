package com.github.hefuduo.chapter3

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.spec.JavaArchive
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * com.github.hefuduo.chapter3
 * Created by hefuduo on 2019-10-11.
 */
@RunWith(Arquillian::class)
class Chapter3KtTest {

    @org.junit.Test
    fun printLots() {
    }

    @org.junit.Test
    fun switchWithNext() {
    }

    @org.junit.Test
    fun switchWithNext2() {
    }

    companion object {
        @Deployment
        fun createDeployment(): JavaArchive {
            return ShrinkWrap.create(JavaArchive::class.java)
                .addClass(Chapter3Kt::class.java)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
        }
    }
}
