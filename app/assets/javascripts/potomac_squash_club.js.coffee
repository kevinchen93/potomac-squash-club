window.PotomacSquashClub =
  Models: {}
  Collections: {}
  Views: {}
  Routers: {}
  initialize: ->
    @AllCourtReservations = [
      { id: 1, court_number: 1, duration_minutes: 60, start_time: '4/1/2015 12:00:00' }
      { id: 2, court_number: 2, duration_minutes: 60, start_time: '4/1/2015 12:30:00' }
      { id: 3, court_number: 3, duration_minutes: 60, start_time: '4/1/2015 12:15:00' }
    ]
    new @Routers.PotomacSquashClubRouter
    Backbone.history.start(pushState: true)

window.App = window.PotomacSquashClub

$(document).ready ->
  PotomacSquashClub.initialize()
