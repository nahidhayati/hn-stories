package objects

import stories.models.{Commenter, Item, Story}

object StoriesDummies {

  val storyIds: List[Int] = List(1, 2, 3)

  val storyItemA: Item = Item(
    id = 1,
    `type` = "Story",
    kids = Some(List(4, 5, 6)),
    title = Some("Story A")
  )

  val storyItemB: Item = Item(
    id = 2,
    `type` = "Story",
    kids = Some(List(10, 11, 12, 13)),
    title = Some("Story B")
  )

  val storyItemC: Item = Item(
    id = 3,
    `type` = "Story",
    kids = Some(List(19, 20, 21)),
    title = Some("Story C")
  )

  val commentItem1: Item = Item(id = 4, by = Some("User A"), `type` = "comment")
  val commentItem2: Item = Item(id = 5, by = Some("User B"), `type` = "comment", kids = Some(List(7)))
  val commentItem3: Item = Item(id = 6, by = Some("User C"), `type` = "comment", kids = Some(List(8,9)))
  val commentItem4: Item = Item(id = 7, by = Some("User C"), `type` = "comment")
  val commentItem5: Item = Item(id = 8, by = Some("User B"), `type` = "comment")
  val commentItem6: Item = Item(id = 9, by = Some("User C"), `type` = "comment")

  val commentItem7: Item = Item(id = 10, by = Some("User A"), `type` = "comment", kids = Some(List(14, 15, 16)))
  val commentItem8: Item = Item(id = 11, by = Some("User A"), `type` = "comment")
  val commentItem9: Item = Item(id = 12, by = Some("User B"), `type` = "comment")
  val commentItem10: Item = Item(id = 13, by = Some("User C"), `type` = "comment", kids = Some(List(17)))
  val commentItem11: Item = Item(id = 14, by = Some("User A"), `type` = "comment")
  val commentItem12: Item = Item(id = 15, by = Some("User B"), `type` = "comment", kids = Some(List(18)))
  val commentItem13: Item = Item(id = 16, by = Some("User C"), `type` = "comment")
  val commentItem14: Item = Item(id = 17, by = Some("User B"), `type` = "comment")
  val commentItem15: Item = Item(id = 18, by = Some("User A"), `type` = "comment")

  val commentItem16: Item = Item(id = 19, by = Some("User A"), `type` = "comment")
  val commentItem17: Item = Item(id = 20, by = Some("User B"), `type` = "comment", kids = Some(List(22, 23, 24, 25)))
  val commentItem18: Item = Item(id = 21, by = Some("User C"), `type` = "comment")
  val commentItem19: Item = Item(id = 22, by = Some("User A"), `type` = "comment", kids = Some(List(26, 27)))
  val commentItem20: Item = Item(id = 23, by = Some("User A"), `type` = "comment")
  val commentItem21: Item = Item(id = 24, by = Some("User C"), `type` = "comment", kids = Some(List(28)))
  val commentItem22: Item = Item(id = 25, by = Some("User B"), `type` = "comment")
  val commentItem23: Item = Item(id = 26, by = Some("User B"), `type` = "comment", kids = Some(List(29)))
  val commentItem24: Item = Item(id = 27, by = Some("User C"), `type` = "comment")
  val commentItem25: Item = Item(id = 28, by = Some("User B"), `type` = "comment")
  val commentItem26: Item = Item(id = 29, by = Some("User A"), `type` = "comment", kids = Some(List(30)))
  val commentItem27: Item = Item(id = 30, by = Some("User B"), `type` = "comment")

  val storyA: Story = Story(
    id = 1,
    title = "Story A",
    commenters = List(
      Commenter(
        by = "User A",
        commentsCount = 1,
        totalCommentsCount = 9
      ),
      Commenter(
        by = "User B",
        commentsCount = 2,
        totalCommentsCount = 10
      ),
      Commenter(
        by = "User C",
        commentsCount = 3,
        totalCommentsCount = 8
      )
    )
  )

  val storyB: Story = Story(
    id = 2,
    title = "Story B",
    commenters = List(
      Commenter(
        by = "User A",
        commentsCount = 4,
        totalCommentsCount = 9
      ),
      Commenter(
        by = "User B",
        commentsCount = 3,
        totalCommentsCount = 10
      ),
      Commenter(
        by = "User C",
        commentsCount = 2,
        totalCommentsCount = 8
      )
    )
  )

  val storyC: Story = Story(
    id = 3,
    title = "Story C",
    commenters = List(
      Commenter(
        by = "User A",
        commentsCount = 4,
        totalCommentsCount = 9
      ),
      Commenter(
        by = "User B",
        commentsCount = 5,
        totalCommentsCount = 10
      ),
      Commenter(
        by = "User C",
        commentsCount = 3,
        totalCommentsCount = 8
      )
    )
  )

}
