window.PotomacSquashClub =
  Models: {}
  Collections: {}
  Views: {}
  Routers: {}
  initialize: ->
    @AllCourtReservations = new @Collections.CourtReservations
    @AllCourtReservations.fetch().done =>
      new @Routers.PotomacSquashClubRouter
      Backbone.history.start(pushState: true)

window.App = window.PotomacSquashClub

$(document).ready ->
  PotomacSquashClub.initialize()
