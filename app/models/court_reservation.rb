class CourtReservation < ActiveRecord::Base

  scope :today, -> { where("start_time BETWEEN ? AND ?", DateTime.now.beginning_of_day, DateTime.now.end_of_day) }

  has_and_belongs_to_many :users
  
  validates :court_number, presence: true
  validates :start_time, presence: true
  
end
