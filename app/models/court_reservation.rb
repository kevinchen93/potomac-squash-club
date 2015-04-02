class CourtReservation < ActiveRecord::Base

  #scope :today, -> { where("start_time BETWEEN ? AND ?", DateTime.now.beginning_of_day, DateTime.now.end_of_day) }
  #scope :today, -> { where("DATE(start_time) = ?", Date.today) }

  has_and_belongs_to_many :users
  
  validates :court_number, presence: true
  validates :start_time, presence: true

  def self.today
    CourtReservation.all.select { |cr| cr.start_time.to_date == Date.today }
  end

  def today?
    self.start_time.to_date == Date.today
  end
  
end
