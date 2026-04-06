import matplotlib.pyplot as plt

# Sample data
solar_angles = [10, 20, 30, 40, 50, 60, 70]
mirror_angles = [5, 10, 15, 20, 25, 30, 35]
efficiencies = [49.7, 50.0, 50.0, 50.0, 50.0, 50.0, 49.7]

# Plot 1: Solar incidence angle vs efficiency
plt.figure(figsize=(8, 5))
plt.plot(solar_angles, efficiencies, marker='o')
plt.title("Solar Incidence Angle vs Efficiency")
plt.xlabel("Solar Incidence Angle (degrees)")
plt.ylabel("Efficiency (%)")
plt.grid(True)
plt.tight_layout()
plt.show()

# Plot 2: Mirror angle vs efficiency
plt.figure(figsize=(8, 5))
plt.plot(mirror_angles, efficiencies, marker='s')
plt.title("Optimal Mirror Angle vs Efficiency")
plt.xlabel("Mirror Angle (degrees)")
plt.ylabel("Efficiency (%)")
plt.grid(True)
plt.tight_layout()
plt.show()