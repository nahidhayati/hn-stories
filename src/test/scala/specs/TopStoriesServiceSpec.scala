package specs

import akka.http.scaladsl.testkit.ScalatestRouteTest
import modules.ServiceTestModule
import objects.StoriesDummies
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import stories.utils.box.BoxComponent

class TopStoriesServiceSpec extends AsyncFlatSpec with Matchers with ScalatestRouteTest
  with ServiceTestModule with BoxComponent {

  "getTopStories method" should "returns a list of top stories" in {

    /** Mock getTopStoryIds to return mock top story ids */
    (client.hackerNewsClient.getTopStoryIds _).when.returns(toBox(StoriesDummies.storyIds))

    /** Mock getItem to return mock stories for the given ids */
    (client.hackerNewsClient.getItem _).when(1).returns(toBox(StoriesDummies.storyItemA))
    (client.hackerNewsClient.getItem _).when(2).returns(toBox(StoriesDummies.storyItemB))
    (client.hackerNewsClient.getItem _).when(3).returns(toBox(StoriesDummies.storyItemC))

    /** Mock getItem to return mock comments for the given ids */
    (client.hackerNewsClient.getItem _).when(4).returns(toBox(StoriesDummies.commentItem1))
    (client.hackerNewsClient.getItem _).when(5).returns(toBox(StoriesDummies.commentItem2))
    (client.hackerNewsClient.getItem _).when(6).returns(toBox(StoriesDummies.commentItem3))
    (client.hackerNewsClient.getItem _).when(7).returns(toBox(StoriesDummies.commentItem4))
    (client.hackerNewsClient.getItem _).when(8).returns(toBox(StoriesDummies.commentItem5))

    (client.hackerNewsClient.getItem _).when(9).returns(toBox(StoriesDummies.commentItem6))
    (client.hackerNewsClient.getItem _).when(10).returns(toBox(StoriesDummies.commentItem7))
    (client.hackerNewsClient.getItem _).when(11).returns(toBox(StoriesDummies.commentItem8))
    (client.hackerNewsClient.getItem _).when(12).returns(toBox(StoriesDummies.commentItem9))
    (client.hackerNewsClient.getItem _).when(13).returns(toBox(StoriesDummies.commentItem10))
    (client.hackerNewsClient.getItem _).when(14).returns(toBox(StoriesDummies.commentItem11))
    (client.hackerNewsClient.getItem _).when(15).returns(toBox(StoriesDummies.commentItem12))
    (client.hackerNewsClient.getItem _).when(16).returns(toBox(StoriesDummies.commentItem13))
    (client.hackerNewsClient.getItem _).when(17).returns(toBox(StoriesDummies.commentItem14))

    (client.hackerNewsClient.getItem _).when(18).returns(toBox(StoriesDummies.commentItem15))
    (client.hackerNewsClient.getItem _).when(19).returns(toBox(StoriesDummies.commentItem16))
    (client.hackerNewsClient.getItem _).when(20).returns(toBox(StoriesDummies.commentItem17))
    (client.hackerNewsClient.getItem _).when(21).returns(toBox(StoriesDummies.commentItem18))
    (client.hackerNewsClient.getItem _).when(22).returns(toBox(StoriesDummies.commentItem19))
    (client.hackerNewsClient.getItem _).when(23).returns(toBox(StoriesDummies.commentItem20))
    (client.hackerNewsClient.getItem _).when(24).returns(toBox(StoriesDummies.commentItem21))
    (client.hackerNewsClient.getItem _).when(25).returns(toBox(StoriesDummies.commentItem22))
    (client.hackerNewsClient.getItem _).when(26).returns(toBox(StoriesDummies.commentItem23))
    (client.hackerNewsClient.getItem _).when(27).returns(toBox(StoriesDummies.commentItem24))
    (client.hackerNewsClient.getItem _).when(28).returns(toBox(StoriesDummies.commentItem25))
    (client.hackerNewsClient.getItem _).when(29).returns(toBox(StoriesDummies.commentItem26))
    (client.hackerNewsClient.getItem _).when(30).returns(toBox(StoriesDummies.commentItem27))

    topStoriesService.getTopStories.value.map {
      res =>

        /** Sort the result from getTopStories so we can compare it with the mock result */
        val sortedRes = res.map(_.sortWith(_.id < _.id))
          .map(_.map {
            story =>
              val c = story.commenters.sortWith(_.by < _.by)
              story.copy(commenters = c)
          })
        assert(
          sortedRes ==
            Right(List(StoriesDummies.storyA, StoriesDummies.storyB, StoriesDummies.storyC))
        )
    }
  }
}
