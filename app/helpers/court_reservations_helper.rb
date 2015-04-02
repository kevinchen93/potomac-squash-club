module CourtReservationsHelper

  def date_format(datetime, hour, minute)
    month = datetime.month
    day = datetime.day
    year = datetime.year
    "#{month}/#{day}/#{year} #{hour}:#{minute}:00"
  end

  def time_from_string(string)
    Time.strptime(string, '%Y-%m-%dT%l:%M:%S-0500')
  end

  def time_now_string
    Time.now.strftime '%Y-%m-%dT%l:%M:%S%z'
  end

  # Returns a list of court reservations today, sorted by start time.
  def court_reservations_today
    today = CourtReservation.on_date(Date.today) #CourtReservation.today
    courts1 = today.where(court_number: 1)
    courts2 = today.where(court_number: 2)
    courts3 = today.where(court_number: 3)
    courts = []
    for i in 1...courts1.length
      c1 = courts1[i]
      c2 = courts2[i]
      c3 = courts3[i]
      break if c1.nil? || c2.nil? || c3.nil?
      courts += [[c1, c2, c3]]
    end
    courts
    CourtReservation.all
  end
end
