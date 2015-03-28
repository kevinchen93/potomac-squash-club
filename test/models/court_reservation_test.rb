require 'test_helper'

class CourtReservationTest < ActiveSupport::TestCase

  test "should create reservation with proper date" do
    cr = CourtReservation.new(court_number: 1, duration_minutes: 60, start_time: "Jan 1st 2015 18:30:00 EST")
    assert_equal 1, cr.start_time.month.to_i
    assert_equal 1, cr.start_time.day.to_i
    assert_equal 2015, cr.start_time.year.to_i
    assert_equal 18, cr.start_time.hour.to_i
    assert_equal 30, cr.start_time.min

    cr = CourtReservation.new(court_number: 1, duration_minutes: 60, start_time: "Jan 1 2015 18:30:00 EST")
    assert_equal 1, cr.start_time.month.to_i
    assert_equal 1, cr.start_time.day.to_i
    assert_equal 2015, cr.start_time.year.to_i
    assert_equal 18, cr.start_time.hour.to_i
    assert_equal 30, cr.start_time.min

    cr = CourtReservation.new(court_number: 1, duration_minutes: 60, start_time: "1/1/2015 18:30:00 EST")
    assert_equal 1, cr.start_time.month.to_i
    assert_equal 1, cr.start_time.day.to_i
    assert_equal 2015, cr.start_time.year.to_i
    assert_equal 18, cr.start_time.hour.to_i
    assert_equal 30, cr.start_time.min

    cr = CourtReservation.new(court_number: 1, duration_minutes: 60, start_time: "Jan 1st 2015 6:30:00 PM EST")
    assert_equal 1, cr.start_time.month.to_i
    assert_equal 1, cr.start_time.day.to_i
    assert_equal 2015, cr.start_time.year.to_i
    assert_equal 18, cr.start_time.hour.to_i
    assert_equal 30, cr.start_time.min
    assert_equal 'EST', cr.start_time.zone
  end

end
