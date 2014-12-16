class CreateCourtReservations < ActiveRecord::Migration
  def change
    create_table :court_reservations do |t|
      t.integer :court_number
      t.string :start_time
      t.string :date

      t.timestamps null: false
    end
  end
end
