package org.kirhgoff.umka

import com.turn.ttorrent.client.{SharedTorrent, Client}
import java.net.InetAddress
import java.io.File
import scala.collection.JavaConverters._
import scala.collection.mutable
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.tag.Tag

object Main {
  private val TORRENT_STORE = "/Users/kirilllastovirya/tmp/torrent/"
  private val DOWNLOAD_LOCATION = "/Users/kirilllastovirya/tmp/download/"
  private val SAMPLE = "/Volumes/sdd2/music/The Doors/The Doors - An American Prayer (1978) (Elektra Records 5E-502-A SP) (USA)/12-13 - The Hitchhiker.m4a"

  def main(args: Array[String]) {
    println ("Umka started!")

    val torrent: SharedTorrent = SharedTorrent.fromFile(
      new File(TORRENT_STORE + "[rutracker.org].t3789879.torrent"),
      new File(DOWNLOAD_LOCATION))

    val filenames = torrent.getFilenames.asScala

    println("Torrent contents: \n" + filenames.sorted.mkString("\n"))

    val tag: Tag = AudioFileIO.read(new File(SAMPLE)).getTag
    println("Tag: " + tag.get)
    //downloadTorrent(torrent)

  }

  def downloadTorrent(torrent: SharedTorrent) {
    val client = new Client(
      InetAddress.getLocalHost(),
      torrent
    )

    client.setMaxDownloadRate(0.0)
    client.setMaxUploadRate(0.0)

    client.download()
    println("Downloading...")
    client.waitForCompletion()
  }
}
